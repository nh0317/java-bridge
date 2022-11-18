package bridge.view;

import bridge.model.BridgeGame;
import bridge.model.Direction;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame game, String direction) {
        System.out.print(printBridge(game, direction));
    }

    private String printBridge(BridgeGame game, String direction){
        boolean success = game.currentBridge().equals(direction);
        game.getGameResultBoard().update(direction, success);
        return makeMap(game.getGameResultBoard().getState());
    }

    private String makeMap(List<List<String>> bridges) {
        StringBuilder map = new StringBuilder();
        for (List<String> bridge : bridges){
            map.append("[ ");
            map.append(String.join(" | ", bridge));
            map.append(" ]\n");
        }
        return map.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {
        System.out.println(Message.FINAL_STATE);
        System.out.println(makeMap(game.getGameResultBoard().getState()));
        System.out.println(Message.GAME_SUCCESS +game.getGameState().stateMsg());
        System.out.println(Message.NUMBER_OF_TRY.toString()+game.getAttempts());
    }

    public void printStart(){
        System.out.println(Message.GAME_START);
    }
}
