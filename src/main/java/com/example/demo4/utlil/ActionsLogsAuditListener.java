package com.example.demo4.utlil;

import com.example.demo4.po.UserJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/*组件类实现对UserJpa实体的持久化监听*/
public class ActionsLogsAuditListener {
    private final String LOG_PREFIX = "ActionsLogsAuditListener 实体持久化监听>>>>>> UserJpa实体执行";
    private final String LOG_POSTFIX = "<<<<<<";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @param userJpa
     */
    @PrePersist
    public void PrePersist(final UserJpa userJpa) {
        this.logger.info("{} [{}] {}", this.LOG_PREFIX, "新增操作之前", LOG_POSTFIX);
    }

    /**
     * @param userJpa
     */
    @PostPersist
    public void PostPersist(final UserJpa userJpa) {
        this.logger.info("{} [{}] {}", this.LOG_PREFIX, "新增操作之后", LOG_POSTFIX);
    }

    /**
     * @param userJpa
     */
    @PreUpdate
    public void PreUpdate(final  UserJpa userJpa) {
        this.logger.info("{} [{}] {}", this.LOG_PREFIX, "更新操作之前", LOG_POSTFIX);
    }

    /**
     * @param userJpa
     */
    @PostUpdate
    public void PostUpdate(final  UserJpa userJpa) {
        this.logger.info("{} [{}] {}", this.LOG_PREFIX, "更新操作之后", LOG_POSTFIX);
    }

    /**
     * @param userJpa
     */
    @PreRemove
    public void PreRemove(final  UserJpa userJpa) {
        this.logger.info("{} [{}] {}", this.LOG_PREFIX, "删除操作之前", LOG_POSTFIX);
    }

    /**
     * @param userJpa
     */
    @PostRemove
    public void PostRemove(final UserJpa userJpa) {
        this.logger.info("{} [{}] {}", this.LOG_PREFIX, "删除操作之后", LOG_POSTFIX);
    }

}
