package model;

public class Note {
	String name;
	String content;
	String []tags;
	
	public Note(String name, String content, String[] tags) {
		super();
		this.name = name;
		this.content = content;
		this.tags = tags;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	public void print(){
		System.out.println("Name: " + name);
		System.out.println("Content: " + content);
		System.out.println("tags: " + tags.toString());
	}

}
