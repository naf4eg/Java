package func.task34_stream_reduce;

enum Category {
    VEGETABLES(3),
    FRUITS(4),
    DAIRY(2);

    private final int times;

    Category (int times) {
        this.times = times;
    }

    public int getTimes () {
        return times;
    }
}
