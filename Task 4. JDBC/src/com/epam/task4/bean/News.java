package com.epam.task4.bean;

import java.io.Serializable;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;
	private Category category;
	private String content;

	public News() {}

	public News(String title, Category category, String content) {
		setTitle(title);
		setCategory(category);
		setContent(content);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		News news = (News) obj;
	
		if (null == title) {
			return (title == news.title);
		} else {
			if (!title.equals(news.title)) {
				return false;
			}
		}

		if (null == category) {
			return (category == news.category);
		} else {
			if (!category.equals(news.category)) {
				return false;
			}
		}

		if (null == content) {
			return (content == news.content);
		} else {
			if (!content.equals(news.content)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = title == null ? 0 : title.hashCode();
		result = 31 * result + (category == null ? 0 : category.hashCode());
		result = 31 * result + (content == null ? 0 : content.hashCode());

		return result;
	}

	@Override
	public String toString() {
		return "title = " + title + ", category = " + category + ", content = " + content + "\n";
	}

}
