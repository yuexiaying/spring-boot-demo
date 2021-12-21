package com.study.listener;

import com.study.event.InsertEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 事务监听器
 *
 * @author fjding
 * @date 2021/12/21
 */
@Component
public class MyTransactionListener {

    @TransactionalEventListener(
            // 默认提交后才会执行
            phase = TransactionPhase.AFTER_COMMIT,
            // 指定监听的事件类型，缩小范围
            classes= com.study.event.InsertEvent.class)
    public void in(InsertEvent insertEvent) {
        System.out.println("监听到事件：" + insertEvent.getSource());
    }
}
