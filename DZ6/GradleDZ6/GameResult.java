package DZ6.GradleDZ6;

public class GameResult {
    private final boolean win;
    private final boolean switched;

    public GameResult(boolean win, boolean switched) {
        this.win = win;
        this.switched = switched;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isSwitched() {
        return switched;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "win=" + win +
                ", switched=" + switched +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameResult that = (GameResult) o;

        if (win != that.win) return false;
        return switched == that.switched;
    }

    @Override
    public int hashCode() {
        int result = (win ? 1 : 0);
        result = 31 * result + (switched ? 1 : 0);
        return result;
    }
}
