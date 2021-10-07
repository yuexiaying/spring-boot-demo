package com.study.config;

import com.study.exception.TestException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * 自定义启动失败处理
 *
 * @author fjding
 * @date 2021/10/6
 */
public class TestFailureAnalyzer extends AbstractFailureAnalyzer<TestException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, TestException cause) {

        return new FailureAnalysis(cause.getMessage(), "检查配置，看是哪错了", cause);
    }
}
