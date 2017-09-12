package com.topie.huaifang.database.core.model;

import javax.persistence.*;

@Table(name = "d_library_book")
public class LibraryBook {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 书名
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 分类
     */
    private String category;

    /**
     * 封面:image
     */
    private String image;

    /**
     * 状态:skip
     */
    private String status;

    /**
     * 简介:textarea
     */
    private String content;

    /**
     * 获取ID:hidden
     *
     * @return id - ID:hidden
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID:hidden
     *
     * @param id ID:hidden
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取书名
     *
     * @return book_name - 书名
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置书名
     *
     * @param bookName 书名
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取分类
     *
     * @return category - 分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置分类
     *
     * @param category 分类
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取封面:image
     *
     * @return image - 封面:image
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置封面:image
     *
     * @param image 封面:image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取状态:skip
     *
     * @return status - 状态:skip
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态:skip
     *
     * @param status 状态:skip
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取简介:textarea
     *
     * @return content - 简介:textarea
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置简介:textarea
     *
     * @param content 简介:textarea
     */
    public void setContent(String content) {
        this.content = content;
    }
}