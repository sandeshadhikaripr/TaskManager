class PendingState implements TaskState {
    @Override
    public void handleTask(Task task) {
        task.setState(new PendingState());
        System.out.println("Task " + task.getId() + " is in Pending state.");
    }
}
