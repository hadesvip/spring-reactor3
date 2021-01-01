package com.kevin.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**·
 * jdk1.8 提供的future(CompletableFuture)
 *
 * @author wangyong
 */
public class CompletableFutureSample {

  public static void main(String[] args) {
    CopyOnWriteArrayList<Integer> taskList = new CopyOnWriteArrayList();
    taskList.add(1);
    taskList.add(2);
    taskList.add(3);
    taskList.add(4);
    taskList.add(5);

    ExecutorService executeService = Executors.newFixedThreadPool(10);
    List<Character> resultList = new ArrayList<>();
    CompletableFuture[] completableFutureArray = taskList.stream()
        //第一阶段
        .map(integer -> CompletableFuture.supplyAsync(() -> calcASCII(integer), executeService)
            //第二阶段
            .thenApply(i -> {
              char c = (char) (i.intValue());
              System.out.println(
                  "[阶段二] 线程" + Thread.currentThread().getName() + "执行完毕，" + "已将int" + i + "转为了字符"
                      + c);
              return c;
            })
            //第三阶段
            .whenComplete((ch, e) -> {
              resultList.add(ch);
              System.out.println(
                  "[阶段三]线程" + Thread.currentThread().getName() + "执行完毕，" + "已将" + ch + "增加到了结果集"
                      + resultList + "中");
              executeService.shutdown();
            })).toArray(CompletableFuture[]::new);

    //封装后无返回值，返回值可以在whenComplete()中保存
    CompletableFuture.allOf(completableFutureArray).join();

    System.out.println("完成！result=" + resultList);
  }


  public static Integer calcASCII(Integer integer) {
    try {
      if (integer == 1) {
        Thread.sleep(5000);
      } else {
        Thread.sleep(1000);
      }

      integer = integer + 64;
      System.out.println("[阶段一]线程" + Thread.currentThread().getName() + "执行完毕，" + "已将" + integer
          + "转为了A（或B或C或D）对应的ASCII" + integer);


    } catch (Exception e) {
      e.printStackTrace();
    }
    return integer;
  }


}
