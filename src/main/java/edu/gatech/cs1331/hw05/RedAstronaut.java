package edu.gatech.cs1331.hw05;

import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private static final int DEFAULT_SUS_LVL = 15;
    private static final String DEFAULT_SKILL = "experienced";
    private String skill;

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    public RedAstronaut(String name) {
        super(name, DEFAULT_SUS_LVL);
        this.skill = DEFAULT_SKILL;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void freeze(Player p) {
        if (!this.isFrozen()) {
            if (!(p instanceof Impostor)) {
                // SUCCESSFUL
                if (this.getSusLevel() < p.getSusLevel()) {
                    p.setFrozen(true);
                // UNSUCCESSFUL
                } else {
                    this.setSusLevel(this.getSusLevel() * 2);
                }
            }

            super.gameOver();
        }
    }

    @Override
    public void sabotage(Player p) {
        if (!this.isFrozen()) {
            if (!(p instanceof Impostor)) {
                if (this.getSusLevel() < 20) {
                    p.setSusLevel(p.getSusLevel() + p.getSusLevel() / 2);
                } else {
                    p.setSusLevel(p.getSusLevel() + p.getSusLevel() / 4);
                }
            }
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

    @Override
    public boolean equals(Object o) {
        return (o instanceof RedAstronaut
                && this.getName().equals(((RedAstronaut) o).getName())
                && this.isFrozen() == ((RedAstronaut) o).isFrozen()
                && this.getSusLevel() == ((RedAstronaut) o).getSusLevel()
                && this.getSkill().equals(((RedAstronaut) o).getSkill()));
    }

    public String toString() {
        if (this.getSusLevel() > 15) {
            return super.toString().toUpperCase();
        }

        return super.toString();
    }
}
