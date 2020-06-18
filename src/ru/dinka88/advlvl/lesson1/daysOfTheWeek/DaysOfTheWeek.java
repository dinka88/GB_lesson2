package ru.dinka88.advlvl.lesson1.daysOfTheWeek;

public enum DaysOfTheWeek {
    Monday(8),
    Tuesday(8),
    Wednesday(8),
    Thursday(8),
    Friday(8),
    Saturday(0),
    Sunday(0);

    private int workingHours;

    DaysOfTheWeek(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void numberOfHours() {
        DaysOfTheWeek[] values = DaysOfTheWeek.values();
        int hoursRemaining = 0;
        if (this.getWorkingHours() == 0) {
            System.out.println("Сегодня выходной!");
        } else {
            for (int i = this.ordinal(); i < values.length; i++) {
                hoursRemaining = hoursRemaining + values[i].getWorkingHours();
            }
            System.out.println(" Колличество оставшихся часв на этой неделе равно " + hoursRemaining);
        }
    }
}
