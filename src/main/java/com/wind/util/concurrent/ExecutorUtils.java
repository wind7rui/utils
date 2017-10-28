package com.wind.util.concurrent;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * 任务执行器工具类
 * <p>可实现并发执行多个任务，多个任务执行完成后再继续执行主线程</p>
 *
 * @author wind
 * @since 2015/9/10
 */
public class ExecutorUtils implements Executor {

    private Executor executor;

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void execute(Runnable command) {
        executor.execute(command);
    }

    /**
     * 多个任务并发执行，多个任务执行完成后再继续执行主线程
     *
     * @param tasks
     * @throws Exception
     */
    public void syncExecute(List<Runnable> tasks) throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(tasks.size());
        for (final Runnable task : tasks) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    task.run();
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
    }
}
