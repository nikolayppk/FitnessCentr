package ru.lushenko.fitnesscentr.console;

public interface Dialog {

    /**
     *
     * @param question - вопрос
     * @return - ответ
     */
    String  ask(String question) ;

    /** Метод для отображения сообщения
     *
     * @param message - сообщение
     */
    void showMessage(String message);

}
