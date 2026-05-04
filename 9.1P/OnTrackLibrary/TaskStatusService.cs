namespace OnTrackLibrary
{
    public class TaskStatusService
    {
        public string GetStatusMessage(string studentId, string taskId, string status)
        {
            if (string.IsNullOrWhiteSpace(studentId))
            {
                return "Invalid student ID.";
            }

            if (string.IsNullOrWhiteSpace(taskId))
            {
                return "Invalid task ID.";
            }

            return status switch
            {
                "NotSubmitted" => $"No submission found for task {taskId}.",
                "Submitted" => $"Task {taskId} has been submitted and is waiting for tutor review.",
                "UnderReview" => $"Task {taskId} is currently being reviewed by your tutor.",
                "NeedsResubmission" => $"Task {taskId} requires resubmission. Please check tutor feedback.",
                "Completed" => $"Task {taskId} has been completed successfully.",
                _ => "Invalid task status."
            };
        }
    }
}