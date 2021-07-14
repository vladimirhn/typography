package kcollections.functional.functions;

import kcollections.functional.AbstractMethod;

@FunctionalInterface
public interface FourArgsFunction <T,N, A,B,C> extends AbstractMethod {
    N apply(T element, A arg1, B arg2, C arg3);
}
