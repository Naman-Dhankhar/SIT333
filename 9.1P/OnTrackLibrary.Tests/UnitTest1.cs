using NUnit.Framework;
using OnTrackLibrary;

namespace OnTrackLibrary.Tests
{
    public class TaskStatusServiceTests
    {
        [Test]
        public void GetStatusMessage_WhenTaskNotSubmitted_ReturnsNoSubmissionMessage()
        {
            TaskStatusService service = new TaskStatusService();

            string result = service.GetStatusMessage("S123", "9.1P", "NotSubmitted");

            Assert.That(result, Is.EqualTo("No submission found for task 9.1P."));
        }

        [Test]
        public void GetStatusMessage_WhenTaskSubmitted_ReturnsWaitingForReviewMessage()
        {
            TaskStatusService service = new TaskStatusService();

            string result = service.GetStatusMessage("S123", "9.1P", "Submitted");

            Assert.That(result, Is.EqualTo("Task 9.1P has been submitted and is waiting for tutor review."));
        }

        [Test]
        public void GetStatusMessage_WhenTaskUnderReview_ReturnsUnderReviewMessage()
        {
            TaskStatusService service = new TaskStatusService();

            string result = service.GetStatusMessage("S123", "9.1P", "UnderReview");

            Assert.That(result, Is.EqualTo("Task 9.1P is currently being reviewed by your tutor."));
        }

        [Test]
        public void GetStatusMessage_WhenTaskNeedsResubmission_ReturnsResubmissionMessage()
        {
            TaskStatusService service = new TaskStatusService();

            string result = service.GetStatusMessage("S123", "9.1P", "NeedsResubmission");

            Assert.That(result, Is.EqualTo("Task 9.1P requires resubmission. Please check tutor feedback."));
        }

        [Test]
        public void GetStatusMessage_WhenTaskCompleted_ReturnsCompletedMessage()
        {
            TaskStatusService service = new TaskStatusService();

            string result = service.GetStatusMessage("S123", "9.1P", "Completed");

            Assert.That(result, Is.EqualTo("Task 9.1P has been completed successfully."));
        }

        [Test]
        public void GetStatusMessage_WhenStatusIsInvalid_ReturnsInvalidStatusMessage()
        {
            TaskStatusService service = new TaskStatusService();

            string result = service.GetStatusMessage("S123", "9.1P", "RandomStatus");

            Assert.That(result, Is.EqualTo("Invalid task status."));
        }

        [Test]
        public void GetStatusMessage_WhenStudentIdIsEmpty_ReturnsInvalidStudentIdMessage()
        {
            TaskStatusService service = new TaskStatusService();

            string result = service.GetStatusMessage("", "9.1P", "Submitted");

            Assert.That(result, Is.EqualTo("Invalid student ID."));
        }

        [Test]
        public void GetStatusMessage_WhenTaskIdIsEmpty_ReturnsInvalidTaskIdMessage()
        {
            TaskStatusService service = new TaskStatusService();

            string result = service.GetStatusMessage("S123", "", "Submitted");

            Assert.That(result, Is.EqualTo("Invalid task ID."));
        }
    }
}