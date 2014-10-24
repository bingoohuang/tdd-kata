package com.github.bingoohuang.tddbj.args;

import com.github.bingoohuang.tddbj.args.exception.ArgFormatException;
import com.github.bingoohuang.tddbj.args.exception.ArgNotFoundException;
import com.github.bingoohuang.tddbj.args.exception.ArgSchemaNotDefinedException;

public class Args {
    private final String[] argsPattern;
    private final String[] realArgs;

    public Args(String argsPattern, String[] realArgs) {
        this.argsPattern = argsPattern.split(",");
        this.realArgs = realArgs;
    }

    public boolean getBoolean(char argName) {
        validateArgSchema(argName, "");

        return findBooleanArg(argName);
    }

    public int getInt(char argName) {
        validateArgSchema(argName, "#");

        return findIntArg(argName);
    }

    public String getString(char argName) {
        validateArgSchema(argName, "*");

        return findStringArg(argName);
    }


    private boolean findBooleanArg(char argName) {
        for (String realArg : realArgs) {
            if (realArg.equals("-" + argName)) return true;
        }
        return false;
    }

    private int findIntArg(char argName) {
        String arg = findStringArg(argName);
        if (arg.matches("\\d+")) {
            return Integer.parseInt(arg);
        }
        throw new ArgFormatException();
    }

    private String findStringArg(char argName) {
        for (String realArg : realArgs) {
            if (realArg.startsWith("-" + argName)) {
                return realArg.substring(2);
            }
        }

        throw new ArgNotFoundException();
    }

    private void validateArgSchema(char argName, String argType) {
        for (String argPattern : argsPattern) {
            if (argPattern.equals(argName + argType)) return;
        }

        throw new ArgSchemaNotDefinedException();
    }
}
