package qna.domain;

import qna.CannotDeleteException;

import java.util.List;

public class Answers {

    private final List<Answer> answers;

    public Answers(List<Answer> answers) {
        this.answers = answers;
    }

    public void delete(User loginUser, DeleteHistories deleteHistories) throws CannotDeleteException {
        for (Answer answer : answers) {
            answer.validate(loginUser);
        }
        answers.stream().map(Answer::delete).forEach(deleteHistories::record);
    }
}
