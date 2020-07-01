public enum DirectionEnum {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    public DirectionEnum getLeftDir(){
        switch (this){
            case RIGHT:
                return UP;
            case UP:
                return LEFT;
            case LEFT:
                return DOWN;
            case DOWN:
                return RIGHT;
            default:
                return null;
        }
    }

    public DirectionEnum getRightDir(){
        switch (this){
            case UP:
                return RIGHT;
            case RIGHT:
                return DOWN;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            default:
                return null;
        }
    }
}
