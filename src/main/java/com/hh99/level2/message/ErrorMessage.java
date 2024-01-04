package com.hh99.level2.message;

public enum ErrorMessage {
    ERROR_HEAD("[ERROR] "),
    EXIST_BOOK_ERROR_MESSAGE("존재하지 않는 도서입니다."),
    EXIST_MEMBER_ERROR_MESSAGE("존재하지 않는 회원입니다."),
    EXIST_LOAN_ERROR_MESSAGE("존재하지 않는 대출 내역 입니다."),
    LOAN_STATUS_BOOK_ERROR_MESSAGE("현재 대출 상태인 도서입니다."),
    RETURN_STATUS_BOOK_ERROR_MESSAGE("반납하지 않은 도서가 있기 때문에, 대출이 불가능합니다."),
    ALREADY_RETURN_ERROR_MESSAGE("해당 도서는 이미 반납된 상태입니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_HEAD + errorMessage;
    }
}
