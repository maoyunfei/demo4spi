package com.mao.demo.spi;

import com.mao.demo.api.IOperation;

/**
 * Description
 *
 * @author maoyunfei
 * @date 2019-04-01
 */
public class DivisionOperationImpl implements IOperation {
    @Override
    public int operate(int numberA, int numberB) {
        return numberA / numberB;
    }
}
