public class Main {
    public static void main(String[] args) {
        System.out.println("=== Gym Management System ===");

        // Создаем тренеров
        Coach coach1 = new Coach("Иванов", "Иван", "Иванович");
        Coach coach2 = new Coach("Петрова", "Мария", "Сергеевна");

        // Создаем группы
        Group childGroup = new Group("Акробатика для детей", Age.CHILD, 60);
        Group adultGroup = new Group("Йога для взрослых", Age.ADULT, 90);

        // Создаем расписание
        Timetable timetable = new Timetable();

        // Добавляем тренировки
        timetable.addNewTrainingSession(new TrainingSession(
                childGroup, coach1, DayOfWeek.MONDAY, new TimeOfDay(10, 0)
        ));

        timetable.addNewTrainingSession(new TrainingSession(
                childGroup, coach1, DayOfWeek.WEDNESDAY, new TimeOfDay(10, 0)
        ));

        timetable.addNewTrainingSession(new TrainingSession(
                adultGroup, coach2, DayOfWeek.MONDAY, new TimeOfDay(18, 0)
        ));

        timetable.addNewTrainingSession(new TrainingSession(
                adultGroup, coach2, DayOfWeek.FRIDAY, new TimeOfDay(18, 0)
        ));

        // Тестируем методы

        System.out.println("\n--- Тренировки в понедельник ---");
        var mondaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        for (var session : mondaySessions) {
            System.out.println(session.getTimeOfDay().getHours() + ":" +
                    session.getTimeOfDay().getMinutes() + " - " +
                    session.getGroup().getTitle());
        }

        System.out.println("\n--- Тренировки в понедельник в 10:00 ---");
        var sessionsAt10 = timetable.getTrainingSessionsForDayAndTime(
                DayOfWeek.MONDAY, new TimeOfDay(10, 0)
        );
        for (var session : sessionsAt10) {
            System.out.println(session.getGroup().getTitle() + " - " +
                    session.getCoach().getSurname());
        }

        System.out.println("\n--- Статистика по тренерам ---");
        var coachStats = timetable.getCountByCoaches();
        for (var stat : coachStats) {
            System.out.println(stat.getCoach().getSurname() + ": " +
                    stat.getCount() + " тренировок");
        }

        System.out.println("\n=== Тестирование завершено ===");
    }
}