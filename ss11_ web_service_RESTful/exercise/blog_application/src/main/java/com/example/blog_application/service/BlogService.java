package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import com.example.blog_application.repository.IBlogRepository;
import com.example.blog_application.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findPostByCategory(String category, Pageable pageable) {
        return iBlogRepository.findPostByCategory(iCategoryRepository.searchIdByName(category),pageable);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog.getTitle(), blog.getContent(), blog.getDate(), blog.getId());
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.remove(id);
    }

    @Override
    public Page<Blog> searchByName(String title, Pageable pageable) {
        return iBlogRepository.searchByName("%" + title + "%", pageable);
    }

    @Override
    public Page<Blog> findPostById(Integer id, Pageable pageable) {
        return iBlogRepository.findPostById(id,pageable);
    }
}
