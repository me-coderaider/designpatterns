package designpatterns.solid.i;

class Document {
}

interface Machine {
	void print(Document d);

	void fax(Document d) throws Exception;

	void scan(Document d) throws Exception;
}

// okay if you need a multifunction machine
class MultiFunctionPrinter implements Machine {
	public void print(Document d) {
		//
	}

	public void fax(Document d) {
		//
	}

	public void scan(Document d) {
		//
	}
}
// not good, as we've to implement the unnecessary methods + in case of throwing 'exceptions' that is also a different issue.
class OldFashionedPrinter implements Machine {
	public void print(Document d) {
		// yep
	}

	public void fax(Document d) throws Exception {
		throw new Exception(); // keep 'empty' or 'throw some exception'
	}

	public void scan(Document d) throws Exception {
		throw new Exception();
	}
}
