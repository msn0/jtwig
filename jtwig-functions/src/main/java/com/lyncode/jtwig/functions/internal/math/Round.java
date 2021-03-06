/**
 * Copyright 2012 Lyncode
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lyncode.jtwig.functions.internal.math;

import com.lyncode.jtwig.functions.Function;
import com.lyncode.jtwig.functions.exceptions.FunctionException;

public class Round implements Function {
    @Override
    public Object execute(Object... arguments) throws FunctionException {
        if (arguments.length < 1 || arguments.length > 2) throw new FunctionException("Invalid number of arguments");

        if (arguments[0] instanceof Integer)
            return arguments[0];
        else if (arguments[0] instanceof Float)
            arguments[0] = (Double) arguments[0];
        else if (!(arguments[0] instanceof Number))
            throw new FunctionException("Invalid first argument. Must be a number");

        String strategy = "common";
        if (arguments.length == 2)
            strategy = arguments[1].toString().toLowerCase();

        switch (RoundStrategy.valueOf(strategy.toUpperCase())) {
            case CEIL:
                return (int) Math.ceil((Double) arguments[0]);
            case FLOOR:
                return (int) Math.floor((Double) arguments[0]);
            default:
                return (int) Math.round((Double) arguments[0]);
        }
    }

    public static enum RoundStrategy {
        COMMON,
        CEIL,
        FLOOR
    }
}
