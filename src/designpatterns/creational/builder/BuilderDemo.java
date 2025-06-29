package designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.Collections;

class HtmlElement {
	public String name, text; // name is for 'tag-name' and text is for 'data between tags'
	public ArrayList<HtmlElement> elements = new ArrayList<HtmlElement>(); // if tag is inside another tag, sort of recursive structure.
	private final int indentSize = 2;
	private final String newLine = System.lineSeparator();

	public HtmlElement() {
	}

	public HtmlElement(String name, String text) {
		this.name = name;
		this.text = text;
	}

	private String toStringImpl(int indent) {
		StringBuilder sb = new StringBuilder();
		String i = String.join("", Collections.nCopies(indent * indentSize, " "));
		sb.append(String.format("%s<%s>%s", i, name, newLine));
		if (text != null && !text.isEmpty()) {
			sb.append(String.join("", Collections.nCopies(indentSize * (indent + 1), " "))).append(text)
					.append(newLine);
		}

		for (HtmlElement e : elements)
			sb.append(e.toStringImpl(indent + 1));

		sb.append(String.format("%s</%s>%s", i, name, newLine));
		return sb.toString();
	}

	@Override
	public String toString() {
		return toStringImpl(0);
	}
}

class HtmlBuilder {
	private String rootName;
	private HtmlElement root = new HtmlElement();

	public HtmlBuilder(String rootName) {
		this.rootName = rootName;
		root.name = rootName;
	}

	// not fluent
	public void addChild(String childName, String childText) {
		HtmlElement e = new HtmlElement(childName, childText);
		root.elements.add(e);
	}

	public HtmlBuilder addChildFluent(String childName, String childText) {
		HtmlElement e = new HtmlElement(childName, childText);
		root.elements.add(e);
		return this; // returning 'this' and return-type as 'HTMLBuilder' for 'Fluent Interface'
	}

	public void clear() {
		root = new HtmlElement();
		root.name = rootName;
	}

	// delegating
	@Override
	public String toString() {
		return root.toString();
	}
}


class BuilderDemo {
	public static void main(String[] args) {

		// we want to build a simple HTML paragraph
		/*System.out.println("Testing");
		String hello = "hello";
		System.out.println("<p>" + hello + "</p>");

		// now we want to build a list with 2 words
		String[] words = { "hello", "world" };
		StringBuilder sb = new StringBuilder();
		sb.append("<ul>\n");
		for (String word : words) {
			// indentation management, line breaks and other evils
			sb.append(String.format("  <li>%s</li>\n", word));
		}
		sb.append("</ul>");
		System.out.println(sb); */

		// ordinary non-fluent builder
		HtmlBuilder builder = new HtmlBuilder("ul");
		builder.addChild("li", "hello");
		builder.addChild("li", "world");
		System.out.println(builder);

		// fluent builder
		builder.clear();
		builder
			.addChildFluent("li", "be")
			.addChildFluent("li", "creative!");
		System.out.println(builder);
	}
}
