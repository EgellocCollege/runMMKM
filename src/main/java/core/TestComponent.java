package core;

public class TestComponent extends AbstractTest{

    TestComponent nextTestComponent;
    public TestComponent addTestComponent(TestComponent testComponent){
        this.nextTestComponent = testComponent;
        return testComponent;
    }

    public boolean hasNext(){
        return nextTestComponent == null ? false:true;
    }
}
