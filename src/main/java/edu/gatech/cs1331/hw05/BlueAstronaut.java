package edu.gatech.cs1331.hw05;

import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    private static final int DEFAULT_SUS_LVL = 15;
    private static final int DEFAULT_NUM_TSK = 6;
    private static final int DEFAULT_TSK_SPD = 10;
    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name) {
        super(name, DEFAULT_SUS_LVL);
        this.numTasks = DEFAULT_NUM_TSK;
        this.taskSpeed = DEFAULT_TSK_SPD;
    }

    /**
     * Constructor for Player Objects. Be sure to use this constructor, as it properly populates the players array.
     * The logic in this constructor ensures that players is always full, although frozen players will still be in it.
     * NOTE: Use getPlayers() each time you need it, since the reference will change with every new instance.
     *
     * @param name     Name of the player
     * @param susLevel Integer that represents the suspicion level, with higher being more suspicious.
     *                 Negative values will be set to a minimum of 0.
     */
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    @Override
    public void completeTask() {
        if (!this.isFrozen()) {
            if (this.getTaskSpeed() > 20) {
                this.setNumTasks(this.getNumTasks() - 2);
            } else {
                this.setNumTasks(this.getNumTasks() - 1);
            }

            if (this.getNumTasks() < 0) this.setNumTasks(0);
        }

        if (this.getNumTasks() == 0) {
            System.out.println("I have completed all my tasks");
            this.setSusLevel(this.getSusLevel() / 2);
        }
    }

    @Override
    public void emergencyMeeting() {
        if (!this.isFrozen()) {
            Arrays.sort(getPlayers(), Player::compareTo);

            Player maxSusPlayer1 = getPlayers()[getPlayers().length - 1];
            Player maxSusPlayer2 = getPlayers()[getPlayers().length - 2];

            if (maxSusPlayer1.getSusLevel() != maxSusPlayer2.getSusLevel()) {
                maxSusPlayer1.setFrozen(true);
            }

            super.gameOver();
        }
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }

    public boolean equals(Object o) {
        return (o instanceof BlueAstronaut
                && this.getName().equals(((BlueAstronaut) o).getName())
                && this.isFrozen() == ((BlueAstronaut) o).isFrozen()
                && this.getSusLevel() == ((BlueAstronaut) o).getSusLevel()
                && this.getNumTasks() == ((BlueAstronaut) o).getNumTasks()
                && this.getTaskSpeed() == ((BlueAstronaut) o).getTaskSpeed());
    }

    public String toString() {
        if (this.getSusLevel() > 15) return super.toString().toUpperCase();

        return super.toString();
    }
}
