package org.github.mlb.content.biz.repository.service;

import org.github.mlb.content.biz.repository.mapper.RepositoryMapper;
import org.github.mlb.content.repository.entity.RepositoryEntity;
import org.github.mlb.content.biz.repository.manager.RepositoryManager;
import org.github.mlb.content.biz.repository.service.impl.RepositoryServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author jihongyuan
 * @date 2022/6/24 10:08
 */
@RunWith(MockitoJUnitRunner.class)
public class RepositoryServiceTest {

    @Mock
    public RepositoryManager repositoryManager;

    @Mock
    public RepositoryMapper repositoryMapper;
    public RepositoryService repositoryService;

    @Test
    public void getBySlug() {
        Mockito
                .doReturn(RepositoryEntity.builder().id(1L).slug("t1").build())
                .when(repositoryManager)
                .selectRepositoryById(1L);

        RepositoryEntity repository = repositoryService.getByRepositoryId(1L);

        Assert.assertNotNull(repository);
        Assert.assertEquals(1L, (long) repository.getId());
        Assert.assertEquals("t1", repository.getSlug());
    }

    @Before
    public void before() {
        Mockito
                .doReturn(false)
                .when(repositoryManager)
                .existSlugByUserId(1L, 1L, "t1");

        Mockito
                .doReturn(true)
                .when(repositoryManager)
                .existSlugByUserId(1L, 1L, "t2");
        repositoryService = new RepositoryServiceImpl(repositoryManager, repositoryMapper);
    }
}
