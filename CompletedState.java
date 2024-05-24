class CompletedState implements TaskState {
    @Override
    public void handleTask(Task task) {
        task.setState(new CompletedState());
        System.out.println("Task " + task.getId() + " is now Completed.");
    }
}
