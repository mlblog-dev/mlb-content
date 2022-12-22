package org.github.mlb.content.biz.repository.manager;

import org.github.mlb.content.repository.entity.RepositoryEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author jihongyuan
 * @date 2022/6/24 9:41
 */
@RunWith(MockitoJUnitRunner.class)
public class RepositoryManagerTest {
    @Mock
    public RepositoryManager repositoryManager;

    @Test
    public void selectRepositoryByIdTest() {
        Mockito
                .doReturn(RepositoryEntity.builder().id(1L).build())
                .when(repositoryManager)
                .selectRepositoryById(1L);
        RepositoryEntity repository = repositoryManager.selectRepositoryById(1L);

        Assert.assertNotNull(repository);
        Assert.assertEquals(1L, (long) repository.getId());
    }


    @Test
    public void existSlugByUserIdTest() {
        Mockito
                .doReturn(false)
                .when(repositoryManager)
                .existSlugByUserId(1L, 1L, "t1");

        Mockito
                .doReturn(true)
                .when(repositoryManager)
                .existSlugByUserId(1L, 1L, "t2");

        boolean t1 = repositoryManager.existSlugByUserId(1L, 1L, "t1");
        Assert.assertFalse(t1);
        boolean t2 = repositoryManager.existSlugByUserId(1L, 1L, "t2");
        Assert.assertTrue(t2);
    }

}
