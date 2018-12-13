package me.buck.samplecode;

/**
 * Created by gwf on 2018/11/22
 */
public enum  EmType {

    Imix(0),
    OPS(1);

    private int value;

    EmType(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
