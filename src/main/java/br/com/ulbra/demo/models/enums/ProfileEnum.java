package br.com.ulbra.demo.models.enums;

public enum ProfileEnum {

    ADMIN(1),
    USER(2);

    private int code;

    private ProfileEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProfileEnum toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (ProfileEnum x : ProfileEnum.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid ProfileEnum code: " + code);
    }
}
      