package me.buck.samplecode.tool;

/**
 * 倒计时
 *
 * 如 SimpleCountDownTimer（5000， 1000）-> {4999, 3987, 2987, 1987, 987, onFinish}
 * 取整需要自己四舍五入
 */
public class SimpleCountDownTimer extends CountDownTimer {
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public SimpleCountDownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    /**
     * 代替 Handler.postDelay 不关心 onTick 事件,只关心 onFinish
     * @param millisInFuture
     */
    public SimpleCountDownTimer(long millisInFuture) {
        this(millisInFuture, millisInFuture + 1000);
    }

    @Override
    public void onTick(long millisUntilFinished) {

    }

    @Override
    public void onFinish() {

    }

    /**
     * 重新计时，一个实用方法
     */
    public void restart() {
        cancel();
        start();
    }
}
