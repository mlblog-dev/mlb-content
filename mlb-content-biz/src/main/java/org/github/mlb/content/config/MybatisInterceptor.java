package org.github.mlb.content.config;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.github.mlb.common.model.BaseEntity;
import org.github.mlb.common.model.UserInfo;
import org.github.mlb.common.utils.UserHolder;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;


/**
 * @author jihongyuan
 * @date 2022/7/1 15:13
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class}

        )
})
public class MybatisInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();

        if (!(args[1] instanceof BaseEntity)) {
            return invocation.proceed();
        }

        BaseEntity base = (BaseEntity) args[1];


        MappedStatement mappedStatement = (MappedStatement) args[0];
        Date date = new Date();

        // TODO lambda待优化
        f2(mappedStatement::getSqlCommandType, SqlCommandType.INSERT, userInfo -> {
            base.setCreateBy(userInfo.getId());
            base.setCreateAt(date);
            base.setUpdateBy(userInfo.getId());
            base.setUpdateAt(date);
            base.setIsDeleted(false);
        });
        f2(mappedStatement::getSqlCommandType, SqlCommandType.UPDATE, userInfo -> {
            base.setUpdateBy(userInfo.getId());
            base.setUpdateAt(date);
        });

        return invocation.proceed();

    }

    public void f2(Supplier<SqlCommandType> supplier, SqlCommandType target, Consumer<UserInfo> consumer) {
        if (supplier.get() == target) {
            UserInfo userInfo = UserHolder.get();
            consumer.accept(userInfo);
        }
    }
}
