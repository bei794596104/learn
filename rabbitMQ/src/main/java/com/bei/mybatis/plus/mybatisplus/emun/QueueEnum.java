package com.bei.mybatis.plus.mybatisplus.emun;

public enum QueueEnum {
    /**
     * 延时队列
     */
    QUEUE_BEI_DEALY("com.bei.direct", "com.bei.task.ttl", "com.bei.task.ttl"),

    /**
     * 实际消费队列
     */
    QUEUE_BEI_task("com.bei.direct", "com.bei.task", "com.bei.task");

	/**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public String getName() {
        return name;
    }

    public String getRouteKey() {
        return routeKey;
    }
}
