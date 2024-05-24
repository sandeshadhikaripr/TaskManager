class OngoingState implements TaskState {
    @Override
    public void handleTask(Task task) {
        task.setState(new OngoingState());
        System.out.println("Task " + task.getId() + " is in Ongoing state.");
    }
}
