package com.mao.demo;

import com.mao.demo.api.IOperation;
import com.mao.demo.spi.DivisionOperationImpl;
import com.mao.demo.spi.PlusOperationImpl;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * Description
 *
 * @author maoyunfei
 * @date 2019-04-01
 */
public class Demo4SPI {
    public static void main(String[] args) {
        IOperation plus = new PlusOperationImpl();
        IOperation division = new DivisionOperationImpl();
        System.out.println(plus.operate(5, 3));
        System.out.println(division.operate(9, 3));
        System.out.println("=====================");

        ServiceLoader<IOperation> operations = ServiceLoader.load(IOperation.class);
        Iterator<IOperation> operationIterator = operations.iterator();
        while (operationIterator.hasNext()) {
            IOperation operation = operationIterator.next();
            System.out.println(operation.operate(6, 3));
        }
        System.out.println("=====================");

        final Optional<IOperation> optionalOperation = StreamSupport.stream(operations.spliterator(), false).findFirst();
        optionalOperation.ifPresent(iOperation -> System.out.println(iOperation.operate(6, 3)));
    }
}
