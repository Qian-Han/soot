package soot.options;

/*-
 * #%L
 * Soot - a J*va Optimization Framework
 * %%
 * Copyright (C) 2003 Ondrej Lhotak
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

/* THIS FILE IS AUTO-GENERATED FROM soot_options.xml. DO NOT MODIFY. */

import java.util.*;

/** Option parser for Lazy Code Motion. */
@javax.annotation.Generated(value = "Saxonica v3.0", date = "2018-06-29T10:19:20.928-04:00", comments = "from soot_options.xml")
public class LCMOptions {

    private Map<String, String> options;

    public LCMOptions(Map<String, String> options) {
        this.options = options;
    }

    /**
     * Enabled
     */
    public boolean enabled() {
        return soot.PhaseOptions.getBoolean(options, "enabled");
    }

    /**
     * Unroll
     * If true, perform loop inversion before doing the transformation.
     */
    public boolean unroll() {
        return soot.PhaseOptions.getBoolean(options, "unroll");
    }

    /**
     * Naive Side Effect Tester --
     * Use a naive side effect analysis even if interprocedural 
     * information is available.
     *
     * If Naive Side Effect Tester is set to true, Lazy Code Motion 
     * uses the conservative side effect information provided by the 
     * NaiveSideEffectTester class, even if interprocedural information 
     * about side effects is available. The naive side effect analysis 
     * is based solely on the information available locally about a 
     * statement. It assumes, for example, that any method call has the 
     * potential to write and read all instance and static fields in 
     * the program. If Naive Side Effect Tester is set to false and 
     * Soot is in whole program mode, then Lazy Code Motion uses the 
     * side effect information provided by the PASideEffectTester 
     * class. PASideEffectTester uses a points-to analysis to determine 
     * which fields and statics may be written or read by a given 
     * statement. If whole program analysis is not performed, naive 
     * side effect information is used regardless of the setting of 
     * Naive Side Effect Tester.
     */
    public boolean naive_side_effect() {
        return soot.PhaseOptions.getBoolean(options, "naive-side-effect");
    }

    public static final int safety_safe = 1;
    public static final int safety_medium = 2;
    public static final int safety_unsafe = 3;

    /**
     * Safety
     * This option controls which fields and statements are candidates 
     * for code motion.
     */
    public int safety() {
        String s = soot.PhaseOptions.getString(options, "safety");
        if (s == null || s.isEmpty())
        	return safety_safe;
	
        if (s.equalsIgnoreCase("safe"))
            return safety_safe;
        if (s.equalsIgnoreCase("medium"))
            return safety_medium;
        if (s.equalsIgnoreCase("unsafe"))
            return safety_unsafe;

        throw new RuntimeException(String.format("Invalid value %s of phase option safety", s));
    }

}
