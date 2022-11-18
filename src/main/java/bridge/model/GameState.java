package bridge.model;

public enum GameState {
    FINISH_SUCCESS(0,true, true),
    FINISH_FAIL(1,true, false),
    NOT_FINISH(2,false, false);

    private boolean success;
    private boolean finish;

    GameState(int state, boolean finish, boolean success) {
        this.success = success;
        this.finish = finish;
    }

    public String stateMsg(){
        if (this.success) return "성공";
        return "실패";
    }

    public Boolean getFinish(){
        return this.finish;
    }
}
