package kcollections;

import kcollections.functional.catchmethods.CollectionCatchMethod;
import kcollections.functional.consumermethods.*;
import kcollections.functional.functions.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KList<T> extends StandartListWrapper<T> {

    private List<T> jList;
    CollectionCatchMethod<kcollections.KList<T>> catchMethod = null;

    //Тип списка и его содержимое задаются на фабрике
    KList(List<T> jList) {
        this.jList = jList;
    }

    @Override
    public List<T> getJList() {
        return jList;
    }

    @Override
    protected kcollections.KList<T> getCurrentKList() {
        return this;
    }

    @Override
    protected kcollections.KList<T> getKListDublicate() {

        List<T> dublicate = makeSameTypeList();

        dublicate.addAll(jList);

        return new kcollections.KList<>(dublicate);
    }

    @Override
    protected kcollections.KList<T> getKListDublicate(int motherCollectionSize) {

        List<T> dublicate = getKListDublicate();
        dublicate.addAll(jList);

        kcollections.KList<T> kList = new kcollections.KList<>(dublicate);
        kList.motherCollectionSize = motherCollectionSize;
        return kList;
    }

    @Override
    protected kcollections.KList<T> getNewKList() {
        return new kcollections.KList<>(makeSameTypeList());
    }

    @Override
    protected <N> kcollections.KList<N> getNewKList(Collection data) {
        List<N> list = makeSameTypeList();
        list.addAll(data);
        return new kcollections.KList<>(list);
    }

    @Override
    protected kcollections.KList<T> streamToNewKCollectionWithMotherSize(Stream<T> stream) {

        kcollections.KList<T> kList = new kcollections.KList<>(stream.collect(Collectors.toList()));
        kList.motherCollectionSize = jList.size();
        return kList;
    }

    private <N> List<N> makeSameTypeList() {
        List<N> sameTypeList;
        try {
            sameTypeList = jList.getClass().newInstance();

        } catch (IllegalAccessException | InstantiationException e) {
            sameTypeList = new ArrayList<>();
        }

        return sameTypeList;
    }

    @Override
    public String toString() {
        return jList.toString();
    }

    //Сортировка

    public <U extends Comparable<? super U>> kcollections.KList<T> sortAsc(Function<? super T, ? extends U> getter) {
        getJList().sort(Comparator.comparing(getter));
        return this;
    }

    public <U extends Comparable<? super U>> kcollections.KList<T> sortDesc(Function<? super T, ? extends U> getter) {
        getJList().sort(Comparator.comparing(getter));
        Collections.reverse(getJList());
        return this;
    }

    //Обработка каждого элемента списка

    //Отображение в коллекцию данных нового типа

    public <N, A, EX extends Exception> kcollections.KList<N> mapEachBy(OneArgFunctionWithEx<A, N, EX> meth, Function<T,A> getter) throws EX {

        List<N> result = new ArrayList<>(getJList().size());
        for (T element : getJList()) {
            A fieldValue = getter.apply(element);
            result.add(meth.apply(fieldValue));
        }
        return getNewKList(result);
    }

    public <N, EX extends Exception> kcollections.KList<N> mapEachBy(OneArgFunctionWithEx<T, N, EX> meth) throws EX {

        List<N> result = new ArrayList<>(getJList().size());
        for (T element : getJList()) {
            result.add(meth.apply(element));
        }
        return getNewKList(result);
    }

    public <N, A, EX extends Exception> kcollections.KList<N> mapEachBy(TwoArgsFunctionWithEx<? super T,N, A, EX> meth, A arg1) throws EX {

        List<N> result = new ArrayList<>(getJList().size());
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1));
        }
        return getNewKList(result);
    }

    public <N, A,B, EX extends Exception> kcollections.KList<N> mapEachBy(ThreeArgsFunctionWithEx<? super T,N, A,B, EX> meth, A arg1, B arg2) throws EX {

        List<N> result = new ArrayList<>(getJList().size());
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1, arg2));
        }
        return getNewKList(result);
    }

    public <N, A,B,C, EX extends Exception> kcollections.KList<N> mapEachBy(FourArgsFunctionWithEx<? super T,N, A,B,C, EX> meth, A arg1, B arg2, C arg3) throws EX {

        List<N> result = new ArrayList<>(getJList().size());
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1, arg2, arg3));
        }
        return getNewKList(result);
    }

    public <N, A,B,C,D, EX extends Exception> kcollections.KList<N> mapEachBy(FiveArgsFunctionWithEx<? super T,N, A,B,C,D, EX> meth, A arg1, B arg2, C arg3, D arg4) throws EX {

        List<N> result = new ArrayList<>(getJList().size());
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1, arg2, arg3, arg4));
        }
        return getNewKList(result);
    }

    public <N, A,B,C,D,E, EX extends Exception> kcollections.KList<N> mapEachBy(SixArgsFunctionWithEx<? super T,N, A,B,C,D,E, EX> meth, A arg1, B arg2, C arg3, D arg4, E arg5) throws EX {

        List<N> result = new ArrayList<>(getJList().size());
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1, arg2, arg3, arg4, arg5));
        }
        return getNewKList(result);
    }

    //Отображение в коллекцию данных нового типа в try/catch
    public <N, EX extends Exception> kcollections.KList<N> tryMapEachBy(OneArgFunctionWithEx<T, N, EX> meth) {

        List<N> result = new ArrayList<>(getJList().size());

        getJList().forEach(element -> {
            try {
                result.add(meth.apply(element));
            } catch (Exception e) {
                errorProcessor.apply(element, e);
            }
        });
        return getNewKList(result);
    }

    public <N, A, EX extends Exception> kcollections.KList<N> tryMapEachBy(TwoArgsFunctionWithEx<? super T,N, A, EX> meth, A arg1) {

        List<N> result = new ArrayList<>(getJList().size());

        getJList().forEach(element -> {
            try {
                result.add(meth.apply(element, arg1));
            } catch (Exception e) {
                errorProcessor.apply(element, e);
            }
        });
        return getNewKList(result);
    }

    public <N, A,B, EX extends Exception> kcollections.KList<N> tryMapEachBy(ThreeArgsFunctionWithEx<? super T,N, A,B, EX> meth, A arg1, B arg2) {

        List<N> result = new ArrayList<>(getJList().size());

        getJList().forEach(element -> {
            try {
                result.add(meth.apply(element, arg1, arg2));
            } catch (Exception e) {
                errorProcessor.apply(element, e);
            }
        });
        return getNewKList(result);
    }

    public <N, A,B,C, EX extends Exception> kcollections.KList<N> tryMapEachBy(FourArgsFunctionWithEx<? super T,N, A,B,C, EX> meth, A arg1, B arg2, C arg3) {

        List<N> result = new ArrayList<>(getJList().size());

        getJList().forEach(element -> {
            try {
                result.add(meth.apply(element, arg1, arg2, arg3));
            } catch (Exception e) {
                errorProcessor.apply(element, e);
            }
        });
        return getNewKList(result);
    }

    public <N, A,B,C,D, EX extends Exception> kcollections.KList<N> tryMapEachBy(FiveArgsFunctionWithEx<? super T,N, A,B,C,D, EX> meth, A arg1, B arg2, C arg3, D arg4) {

        List<N> result = new ArrayList<>(getJList().size());

        getJList().forEach(element -> {
            try {
                result.add(meth.apply(element, arg1, arg2, arg3, arg4));
            } catch (Exception e) {
                errorProcessor.apply(element, e);
            }
        });
        return getNewKList(result);
    }

    public <N, A,B,C,D,E, EX extends Exception> kcollections.KList<N> tryMapEachBy(SixArgsFunctionWithEx<? super T,N, A,B,C,D,E, EX> meth, A arg1, B arg2, C arg3, D arg4, E arg5) {

        List<N> result = new ArrayList<>(getJList().size());

        getJList().forEach(element -> {
            try {
                result.add(meth.apply(element, arg1, arg2, arg3, arg4, arg5));
            } catch (Exception e) {
                errorProcessor.apply(element, e);
            }
        });
        return getNewKList(result);
    }

    //Отображение непустых полей в коллекцию данных нового типа
    public <N, EX extends Exception> kcollections.KList<N> mapToNonNullsBy(OneArgFunctionWithEx<T, N, EX> meth) throws EX {

        kcollections.KList<N> result = new kcollections.KList<>(new ArrayList<>(getJList().size()));
        for (T element : getJList()) {
            result.add(meth.apply(element));
        }
        return result.filterNonNulls(i->i);
    }

    public <N, A, EX extends Exception> kcollections.KList<N> mapToNonNullsBy(TwoArgsFunctionWithEx<? super T,N, A, EX> meth, A arg1) throws EX {

        kcollections.KList<N> result = new kcollections.KList<>(new ArrayList<>(getJList().size()));
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1));
        }
        return result.filterNonNulls(i->i);
    }

    public <N, A,B, EX extends Exception> kcollections.KList<N> mapToNonNullsBy(ThreeArgsFunctionWithEx<? super T,N, A,B, EX> meth, A arg1, B arg2) throws EX {

        kcollections.KList<N> result = new kcollections.KList<>(new ArrayList<>(getJList().size()));
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1, arg2));
        }
        return result.filterNonNulls(i->i);
    }

    public <N, A,B,C, EX extends Exception> kcollections.KList<N> mapToNonNullsBy(FourArgsFunctionWithEx<? super T,N, A,B,C, EX> meth, A arg1, B arg2, C arg3) throws EX {

        kcollections.KList<N> result = new kcollections.KList<>(new ArrayList<>(getJList().size()));
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1, arg2, arg3));
        }
        return result.filterNonNulls(i->i);
    }

    public <N, A,B,C,D, EX extends Exception> kcollections.KList<N> mapToNonNullsBy(FiveArgsFunctionWithEx<? super T,N, A,B,C,D, EX> meth, A arg1, B arg2, C arg3, D arg4) throws EX {

        kcollections.KList<N> result = new kcollections.KList<>(new ArrayList<>(getJList().size()));
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1, arg2, arg3, arg4));
        }
        return result.filterNonNulls(i->i);
    }

    public <N, A,B,C,D,E, EX extends Exception> kcollections.KList<N> mapToNonNullsBy(SixArgsFunctionWithEx<? super T,N, A,B,C,D,E, EX> meth, A arg1, B arg2, C arg3, D arg4, E arg5) throws EX {

        kcollections.KList<N> result = new kcollections.KList<>(new ArrayList<>(getJList().size()));
        for (T element : getJList()) {
            result.add(meth.apply(element, arg1, arg2, arg3, arg4, arg5));
        }
        return result.filterNonNulls(i->i);
    }

    //Обработка списка целиком (не умеет в проверяемые исключения)

    //Передача списка в метод, не возвращающий значения
    public kcollections.KList<T> withCollectionCatchMethod(CollectionCatchMethod<kcollections.KList<T>> catchMethod) {
        this.catchMethod = catchMethod;
        return getCurrentKList();
    }

    public <EX extends Exception> kcollections.KList<T> useWholeBy(ConsumerMethodWithEx<kcollections.KList<T>, EX> meth) throws EX {
        meth.apply(getCurrentKList());
        return getCurrentKList();
    }

    public <A, EX extends Exception> kcollections.KList<T> useWholeBy(TwoArgsConsumerMethodWithEx<kcollections.KList<T>, A, EX> meth, A arg1) throws EX {
        meth.apply(getCurrentKList(), arg1);
        return getCurrentKList();
    }

    public <A,B, EX extends Exception> kcollections.KList<T> useWholeBy(ThreeArgsConsumerMethodWithEx<kcollections.KList<T>, A,B, EX> meth, A arg1, B arg2) throws EX {
        meth.apply(getCurrentKList(), arg1, arg2);
        return getCurrentKList();
    }

    public <A,B,C, EX extends Exception> kcollections.KList<T> useWholeBy(FourArgsConsumerMethodWithEx<kcollections.KList<T>, A,B,C, EX> meth, A arg1, B arg2, C arg3) throws EX {
        meth.apply(getCurrentKList(), arg1, arg2, arg3);
        return getCurrentKList();
    }

    public <A,B,C,D, EX extends Exception> kcollections.KList<T> useWholeBy(FiveArgsConsumerMethodWithEx<kcollections.KList<T>, A,B,C,D, EX> meth, A arg1, B arg2, C arg3, D arg4) throws EX {
        meth.apply(getCurrentKList(), arg1, arg2, arg3, arg4);
        return getCurrentKList();
    }

    public <A,B,C,D,E, EX extends Exception> kcollections.KList<T> useWholeBy(SixArgsConsumerMethodWithEx<kcollections.KList<T>, A,B,C,D,E, EX> meth, A arg1, B arg2, C arg3, D arg4, E arg5) throws EX {
        meth.apply(getCurrentKList(), arg1, arg2, arg3, arg4, arg5);
        return getCurrentKList();
    }

    //Передача списка в метод, не возвращающий значения + try/catch
    public <EX extends Exception> kcollections.KList<T> tryUseWholeBy(ConsumerMethodWithEx<kcollections.KList<T>, EX> meth) {
        try {
            meth.apply(getCurrentKList());
        } catch (Exception e) {
            catchMethod.apply(getCurrentKList(), e);
        }
        return getCurrentKList();
    }

    public <A, EX extends Exception> kcollections.KList<T> tryUseWholeBy(TwoArgsConsumerMethodWithEx<kcollections.KList<T>, A, EX> meth, A arg1) {
        try {
            meth.apply(getCurrentKList(), arg1);
        } catch (Exception e) {
            catchMethod.apply(getCurrentKList(), e);
        }
        return getCurrentKList();
    }

    public <A,B, EX extends Exception> kcollections.KList<T> tryUseWholeBy(ThreeArgsConsumerMethodWithEx<kcollections.KList<T>, A,B, EX> meth, A arg1, B arg2) {
        try {
            meth.apply(getCurrentKList(), arg1, arg2);
        } catch (Exception e) {
            catchMethod.apply(getCurrentKList(), e);
        }
        return getCurrentKList();
    }

    public <A,B,C, EX extends Exception> kcollections.KList<T> tryUseWholeBy(FourArgsConsumerMethodWithEx<kcollections.KList<T>, A,B,C, EX> meth, A arg1, B arg2, C arg3) {
        try {
            meth.apply(getCurrentKList(), arg1, arg2, arg3);
        } catch (Exception e) {
            catchMethod.apply(getCurrentKList(), e);
        }
        return getCurrentKList();
    }

    public <A,B,C,D, EX extends Exception> kcollections.KList<T> tryUseWholeBy(FiveArgsConsumerMethodWithEx<kcollections.KList<T>, A,B,C,D, EX> meth, A arg1, B arg2, C arg3, D arg4) {
        try {
            meth.apply(getCurrentKList(), arg1, arg2, arg3, arg4);
        } catch (Exception e) {
            catchMethod.apply(getCurrentKList(), e);
        }
        return getCurrentKList();
    }

    public <A,B,C,D,E, EX extends Exception> kcollections.KList<T> tryUseWholeBy(SixArgsConsumerMethodWithEx<kcollections.KList<T>, A,B,C,D,E, EX> meth, A arg1, B arg2, C arg3, D arg4, E arg5) {
        try {
            meth.apply(getCurrentKList(), arg1, arg2, arg3, arg4, arg5);
        } catch (Exception e) {
            catchMethod.apply(getCurrentKList(), e);
        }
        return getCurrentKList();
    }

    //Отображение всего списка во что-угодно
    public <N, EX extends Exception> N mapWholeBy(OneArgFunctionWithEx<kcollections.KList<T>,N, EX> meth) throws EX {
        return meth.apply(getCurrentKList());
    }

    public <N, A, EX extends Exception> N mapWholeBy(TwoArgsFunctionWithEx<kcollections.KList<T>,N, A, EX> meth, A arg1) throws EX {
        return meth.apply(getCurrentKList(), arg1);
    }

    public <N, A,B, EX extends Exception> N mapWholeBy(ThreeArgsFunctionWithEx<kcollections.KList<T>,N, A,B, EX> meth, A arg1, B arg2) throws EX {
        return meth.apply(getCurrentKList(), arg1, arg2);
    }

    public <N, A,B,C, EX extends Exception> N mapWholeBy(FourArgsFunctionWithEx<kcollections.KList<T>,N, A,B,C, EX> meth, A arg1, B arg2, C arg3) throws EX {
        return meth.apply(getCurrentKList(), arg1, arg2, arg3);
    }

    public <N, A,B,C,D, EX extends Exception> N mapWholeBy(FiveArgsFunctionWithEx<kcollections.KList<T>,N, A,B,C,D, EX> meth, A arg1, B arg2, C arg3, D arg4) throws EX {
        return meth.apply(getCurrentKList(), arg1, arg2, arg3, arg4);
    }

    public <N, A,B,C,D,E, EX extends Exception> N mapWholeBy(SixArgsFunctionWithEx<kcollections.KList<T>,N, A,B,C,D,E, EX> meth, A arg1, B arg2, C arg3, D arg4, E arg5) throws EX {
        return meth.apply(getCurrentKList(), arg1, arg2, arg3, arg4, arg5);
    }


    //Отображение всего списка во что-угодно + try/catch
    public <N, EX extends Exception> N tryMapWholeBy(OneArgFunctionWithEx<kcollections.KList<T>,N, EX> meth) {
        try {
            return meth.apply(getCurrentKList());
        } catch (Exception e) {
            catchMethod.apply(this, e);
        }
        return null;
    }

    public <N, A, EX extends Exception> N tryMapWholeBy(TwoArgsFunctionWithEx<kcollections.KList<T>,N, A, EX> meth, A arg1) {
            try {
                return meth.apply(getCurrentKList(), arg1);
            } catch (Exception e) {
                catchMethod.apply(this, e);
            }
        return null;
    }

    public <N, A,B, EX extends Exception> N tryMapWholeBy(ThreeArgsFunctionWithEx<kcollections.KList<T>,N, A,B, EX> meth, A arg1, B arg2) {
        try {
            return meth.apply(getCurrentKList(), arg1, arg2);
        } catch (Exception e) {
            catchMethod.apply(this, e);
        }
        return null;
    }

    public <N, A,B,C, EX extends Exception> N tryMapWholeBy(FourArgsFunctionWithEx<kcollections.KList<T>,N, A,B,C, EX> meth, A arg1, B arg2, C arg3) {
        try {
            return meth.apply(getCurrentKList(), arg1, arg2, arg3);
        } catch (Exception e) {
            catchMethod.apply(this, e);
        }
        return null;
    }

    public <N, A,B,C,D, EX extends Exception> N tryMapWholeBy(FiveArgsFunctionWithEx<kcollections.KList<T>,N, A,B,C,D, EX> meth, A arg1, B arg2, C arg3, D arg4) {
        try {
            return meth.apply(getCurrentKList(), arg1, arg2, arg3, arg4);
        } catch (Exception e) {
            catchMethod.apply(this, e);
        }
        return null;
    }

    public <N, A,B,C,D,E, EX extends Exception> N tryMapWholeBy(SixArgsFunctionWithEx<kcollections.KList<T>,N, A,B,C,D,E, EX> meth, A arg1, B arg2, C arg3, D arg4, E arg5) {
        try {
            return meth.apply(getCurrentKList(), arg1, arg2, arg3, arg4, arg5);
        } catch (Exception e) {
            catchMethod.apply(this, e);
        }
        return null;
    }

    //Извлечение данных
    public Optional<T> getFirst() {
        if (getCurrentKList().isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(getCurrentKList().get(0));
        }
    }

    public <E extends Exception> T getFirstOr(E e) throws E {
        if (getCurrentKList().isEmpty()) {
            throw e;
        } else {
            return getCurrentKList().get(0);
        }
    }
}
