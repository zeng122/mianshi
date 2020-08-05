package DesignPattern;

/**状态模式 关注事物的状态,一个状态经过处理后到另一个状态*/
public class StateDemo {
    public static void main(String [] args){
        ScoreContext account=new ScoreContext();
        System.out.println("学生成绩状态测试：");
        account.add(30);
        account.add(40);
        account.add(25);
        account.add(-15);
        account.add(-25);
    }

}


//环境类 用户接口

class ScoreContext
{
    private State state;
    ScoreContext()
    {
        state=new LowState(this);
    }

    public void setState(State state)
    {
        this.state=state;
    }

    public State getState()
    {
        return state;
    }

    public void add(int score)
    {
        state.addScore(score);
    }
}

//抽象状态类
abstract class State{
    protected ScoreContext scoreContext;  //环境
    protected String stateName; //状态名
    protected int score; //分
    public abstract void checkState(); //检查当前状态
    public void addScore(int x)
    {
        score+=x;
        System.out.print("加上："+x+"分，\t当前分数："+score );
        checkState();
        System.out.println("分，\t当前状态："+scoreContext.getState().stateName);
    }
}

//具体状态类：不及格
class LowState extends State
{
    //初始化
    public LowState(ScoreContext h)
    {
        scoreContext=h;
        stateName="不及格";
        score=0;
    }

    public LowState(State state)
    {
        scoreContext=state.scoreContext;
        stateName="不及格";
        score=state.score;
    }

    public void checkState()
    {
        if(score>=90)
        {
            scoreContext.setState(new HighState(this));
        }
        else if(score>=60)
        {
            scoreContext.setState(new MiddleState(this));
        }
    }
}


class MiddleState extends State
{
    public MiddleState(State state)
    {
        scoreContext=state.scoreContext;
        stateName="中等";
        score=state.score;
    }
    public void checkState()
    {
        if(score<60)
        {
            scoreContext.setState(new LowState(this));
        }
        else if(score>=90)
        {
            scoreContext.setState(new HighState(this));
        }
    }
}

//具体状态类：优秀
class HighState extends State
{
    public HighState(State state)
    {
        scoreContext=state.scoreContext;
        stateName="优秀";
        score=state.score;
    }
    public void checkState()
    {
        if(score<60)
        {
            scoreContext.setState(new LowState(this));
        }
        else if(score<90)
        {
            scoreContext.setState(new MiddleState(this));
        }
    }
}