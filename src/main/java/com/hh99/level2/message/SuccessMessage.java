package com.hh99.level2.message;

public enum SuccessMessage {
    SUCCESS_HEAD("[SUCCESS] "),
    LOAN_SUCCESS_MESSAGE("도서 대출이 완료되었습니다."),
    RETURN_SUCCESS_MESSAGE("도서 반납이 완료되었습니다.");

    private final String successMessage;

    SuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getSuccessMessage() {
        return SUCCESS_HEAD + successMessage;
    }
}
