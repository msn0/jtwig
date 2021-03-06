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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class JNumberFormat implements Function {
    @Override
    public Object execute(Object... arguments) throws FunctionException {
        if (arguments.length < 1 || arguments.length > 4) throw new FunctionException("Invalid number of arguments");
        DecimalFormat numberFormat = new DecimalFormat();
        DecimalFormatSymbols decimalFormatSymbols = numberFormat.getDecimalFormatSymbols();

        if (arguments.length > 1) {
            numberFormat.setMaximumFractionDigits((Integer) arguments[1]);
            numberFormat.setMinimumFractionDigits((Integer) arguments[1]);
        }

        if (arguments.length > 2) {
            String separator = arguments[2].toString();
            if (!separator.isEmpty())
                decimalFormatSymbols.setDecimalSeparator(separator.charAt(0));
            else
                decimalFormatSymbols.setDecimalSeparator('\0');
        }

        if (arguments.length > 3) {
            String separator = arguments[3].toString();
            if (!separator.isEmpty())
                decimalFormatSymbols.setGroupingSeparator(separator.charAt(0));
            else
                decimalFormatSymbols.setGroupingSeparator('\0');
        }

        numberFormat.setDecimalFormatSymbols(decimalFormatSymbols);

        return numberFormat.format(arguments[0]);
    }
}
