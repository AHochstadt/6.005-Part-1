import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MakerListener extends BoardMakerBaseListener {
    private int badNumber = -9999;
    private ArrayList<Stationary> nonMovingParts;
    private ArrayList<Flipper> flippers;
    private ArrayList<Gadget> allParts;
    private ArrayList<Ball> balls;
    private Stack<String> stack;
    private float gravity = badNumber;
    private float friction1 = badNumber;
    private float friction2 = badNumber;
    private String boardName;
    private HashMap<String, String> triggerMap; // maps string names of objects
                                                // that trigger as keys, and
                                                // actions as values

    MakerListener() {
        nonMovingParts = new ArrayList<Stationary>();
        flippers = new ArrayList<Flipper>();
        balls = new ArrayList<Ball>();
        stack = new Stack<String>();
        triggerMap = new HashMap<String, String>();
        allParts = new ArrayList<Gadget>();

    }

    @Override
    public void enterFriction1(BoardMakerParser.Friction1Context ctx) {
    }

    @Override
    public void exitFriction1(BoardMakerParser.Friction1Context ctx) {
        // friction1: FRICTION1FIELD FLOAT;
        TerminalNode token = ctx.FRICTION1FIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.FLOAT();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterTriangleBumper(BoardMakerParser.TriangleBumperContext ctx) {
    }

    @Override
    public void exitTriangleBumper(BoardMakerParser.TriangleBumperContext ctx) {
        // triangleBumper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER
        // ORIENTATIONFIELD INTEGER;
        String name = null;
        int x = 0;
        int y = 0;
        int orientation = 0;
        for (int i = 0; i < 4; i++) {
            String value = stack.pop();
            String field = stack.pop();
            if (field.equals("name=")) {
                name = value;
            }
            if (field.equals("x=")) {
                x = Integer.parseInt(value);
            }

            if (field.equals("y=")) {
                y = Integer.parseInt(value);
            }

            if (field.equals("orientation=")) {
                orientation = Integer.parseInt(value);
            }
        }

        TriangularBumper t;
        try {
            t = new TriangularBumper(x, y, orientation, name);
            nonMovingParts.add(t);
            allParts.add(t);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void enterTrigger(BoardMakerParser.TriggerContext ctx) {
    }

    @Override
    public void exitTrigger(BoardMakerParser.TriggerContext ctx) {
        // trigger: TRIGGERFIELD NAME;
        TerminalNode token = ctx.TRIGGERFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.NAME();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterOrientation(BoardMakerParser.OrientationContext ctx) {
    }

    @Override
    public void exitOrientation(BoardMakerParser.OrientationContext ctx) {
        // orientation: ORIENTATIONFIELD INTEGER;
        TerminalNode token = ctx.ORIENTATIONFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.INTEGER();
        text = token.getText();
        node = new String(text);
        stack.push(node);

    }

    @Override
    public void enterAbsorber(BoardMakerParser.AbsorberContext ctx) {
    }

    @Override
    public void exitAbsorber(BoardMakerParser.AbsorberContext ctx) {
        // absorber: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER WIDTHFIELD INTEGER HEIGHTFIELD INTEGER;
        String name = null;
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        for (int i = 0; i < 5; i++) {
            String value = stack.pop();
            String field = stack.pop();
            if (field.equals("name=")) {
                name = value;
            }
            if (field.equals("x=")) {
                x = Integer.parseInt(value);
            }

            if (field.equals("y=")) {
                y = Integer.parseInt(value);
            }

            if (field.equals("width=")) {
                width = Integer.parseInt(value);
            }

            if (field.equals("height=")) {
                height = Integer.parseInt(value);

            }
        }

        Absorber a = new Absorber(x, y, width, height, name);
        nonMovingParts.add(a);
        allParts.add(a);
    }

    @Override
    public void enterBall(BoardMakerParser.BallContext ctx) {
    }

    @Override
    public void exitBall(BoardMakerParser.BallContext ctx) {
        // ball: NAMEFIELD NAME XFIELD FLOAT YFIELD FLOAT XVELOCITYFIELD FLOAT YVELOCITYFIELD FLOAT;
        String name = null;
        float x = 0;
        float y = 0;
        float xvelocity = 0;
        float yvelocity = 0;
        for (int i = 0; i < 5; i++) {
            String value = stack.pop();
            String field = stack.pop();
            if (field.equals("name=")) {
                name = value;
            }
            if (field.equals("x=")) {
                x = Float.parseFloat(value);
            }

            if (field.equals("y=")) {
                y = Float.parseFloat(value);
            }

            if (field.equals("xVelocity=")) {
                xvelocity = Float.parseFloat(value);
            }

            if (field.equals("yVelocity=")) {
                yvelocity = Float.parseFloat(value);

            }
        }

        Ball b = new Ball(x, y, xvelocity, yvelocity, name);
        balls.add(b);
    }

    @Override
    public void enterSquareBumper(BoardMakerParser.SquareBumperContext ctx) {
    }

    @Override
    public void exitSquareBumper(BoardMakerParser.SquareBumperContext ctx) {
        // squareBumper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER;
        String name = null;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 3; i++) {
            String value = stack.pop();
            String field = stack.pop();
            if (field.equals("name=")) {
                name = value;
            }
            if (field.equals("x=")) {
                x = Integer.parseInt(value);
            }

            if (field.equals("y=")) {
                y = Integer.parseInt(value);
            }

        }

        SquareBumper s = new SquareBumper(x, y, name);
        nonMovingParts.add(s);
        allParts.add(s);
    }

    @Override
    public void enterWidth(BoardMakerParser.WidthContext ctx) {
    }

    @Override
    public void exitWidth(BoardMakerParser.WidthContext ctx) {
        // width: WIDTHFIELD INTEGER;
        TerminalNode token = ctx.WIDTHFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.INTEGER();
        text = token.getText();
        node = new String(text);
        stack.push(node);

    }

    @Override
    public void enterCircleBumper(BoardMakerParser.CircleBumperContext ctx) {
    }

    @Override
    public void exitCircleBumper(BoardMakerParser.CircleBumperContext ctx) {
        // circleBumper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER;
        String name = null;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 3; i++) {
            String value = stack.pop();
            String field = stack.pop();
            if (field.equals("name=")) {
                name = value;
            }
            if (field.equals("x=")) {
                x = Integer.parseInt(value);
            }

            if (field.equals("y=")) {
                y = Integer.parseInt(value);
            }

        }

        CircularBumper c = new CircularBumper(x, y, name);
        nonMovingParts.add(c);
        allParts.add(c);
    }

    @Override
    public void enterBoard(BoardMakerParser.BoardContext ctx) {
    }

    @Override
    public void exitBoard(BoardMakerParser.BoardContext ctx) {
        // board: NAMEFIELD NAME GRAVITYFIELD FLOAT FRICTION1FIELD FLOAT FRICTION2FIELD FLOAT;
        for (int i = 0; i < stack.size(); i++) {
            String value = stack.pop();
            String field = stack.pop();
            if (field.equals("name=")) {
                this.boardName = value;
            }
            if (field.equals("gravity=")) {
                this.gravity = Float.parseFloat(value);
            }

            if (field.equals("friction1=")) {
                this.friction1 = Float.parseFloat(value);
            }

            if (field.equals("friction2=")) {
                this.friction2 = Float.parseFloat(value);

            }
        }
    }

    @Override
    public void enterXball(BoardMakerParser.XballContext ctx) {
    }

    @Override
    public void exitXball(BoardMakerParser.XballContext ctx) {
        // xball: XFIELD FLOAT;
        TerminalNode token = ctx.XFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.FLOAT();
        text = token.getText();
        node = new String(text);
        stack.push(node);

    }

    @Override
    public void enterFire(BoardMakerParser.FireContext ctx) {
    }

    @Override
    public void exitFire(BoardMakerParser.FireContext ctx) {
        // fire: TRIGGERFIELD NAME ACTIONFIELD NAME;
        String trigger = null;
        String action = null;
        for (int i = 0; i < 2; i++) {
            String value = stack.pop();
            String field = stack.pop();
            if (field.equals("trigger=")) {
                trigger = value;
            }
            if (field.equals("action=")) {
                action = value;
            }

        }
        triggerMap.put(trigger, action);

    }

    @Override
    public void enterFriction2(BoardMakerParser.Friction2Context ctx) {
    }

    @Override
    public void exitFriction2(BoardMakerParser.Friction2Context ctx) {
        // friction2: FRICTION2FIELD FLOAT;
        TerminalNode token = ctx.FRICTION2FIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.FLOAT();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterYball(BoardMakerParser.YballContext ctx) {
    }

    @Override
    public void exitYball(BoardMakerParser.YballContext ctx) {
        // yball: YFIELD FLOAT;
        TerminalNode token = ctx.YFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.FLOAT();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterHeight(BoardMakerParser.HeightContext ctx) {
    }

    @Override
    public void exitHeight(BoardMakerParser.HeightContext ctx) {
        // height: HEIGHTFIELD INTEGER;
        TerminalNode token = ctx.HEIGHTFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.INTEGER();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterYvelocity(BoardMakerParser.YvelocityContext ctx) {
    }

    @Override
    public void exitYvelocity(BoardMakerParser.YvelocityContext ctx) {
        // yvelocity: YVELOCITYFIELD FLOAT;
        TerminalNode token = ctx.YVELOCITYFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.FLOAT();
        text = token.getText();
        node = new String(text);
        stack.push(node);

    }

    @Override
    public void enterFile(BoardMakerParser.FileContext ctx) {
        //
        //
    }

    @Override
    public void exitFile(BoardMakerParser.FileContext ctx) {
    }

    @Override
    public void enterName(BoardMakerParser.NameContext ctx) {
    }

    @Override
    public void exitName(BoardMakerParser.NameContext ctx) {
        // name: NAMEFIELD NAME;
        TerminalNode token = ctx.NAMEFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.NAME();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterAction(BoardMakerParser.ActionContext ctx) {
    }

    @Override
    public void exitAction(BoardMakerParser.ActionContext ctx) {
        // action: ACTIONFIELD NAME;
        TerminalNode token = ctx.ACTIONFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.NAME();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterXvelocity(BoardMakerParser.XvelocityContext ctx) {
    }

    @Override
    public void exitXvelocity(BoardMakerParser.XvelocityContext ctx) {
        // xvelocity: XVELOCITYFIELD FLOAT;
        TerminalNode token = ctx.XVELOCITYFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.FLOAT();
        text = token.getText();
        node = new String(text);
        stack.push(node);

    }

    @Override
    public void enterRightFlipper(BoardMakerParser.RightFlipperContext ctx) {
    }

    @Override
    public void exitRightFlipper(BoardMakerParser.RightFlipperContext ctx) {
        // rightFlipper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER
        // ORIENTATIONFIELD INTEGER;
        String name = null;
        int x = 0;
        int y = 0;
        int orientation = 0;
        for (int i = 0; i < 4; i++) {
            String value = stack.pop();
            String field = stack.pop();
            if (field.equals("name=")) {
                name = value;
            }
            if (field.equals("x=")) {
                x = Integer.parseInt(value);
            }

            if (field.equals("y=")) {
                y = Integer.parseInt(value);
            }

            if (field.equals("orientation=")) {
                orientation = Integer.parseInt(value);
            }
        }
        RightFlipper r;
        try {
            r = new RightFlipper(x, y, orientation, name);
            flippers.add(r);
            allParts.add(r);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void enterY(BoardMakerParser.YContext ctx) {
    }

    @Override
    public void exitY(BoardMakerParser.YContext ctx) {
        // y: YFIELD INTEGER;
        TerminalNode token = ctx.YFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.INTEGER();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterX(BoardMakerParser.XContext ctx) {
    }

    @Override
    public void exitX(BoardMakerParser.XContext ctx) {
        // x: XFIELD INTEGER;
        TerminalNode token = ctx.XFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.INTEGER();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterLeftFlipper(BoardMakerParser.LeftFlipperContext ctx) {
    }

    @Override
    public void exitLeftFlipper(BoardMakerParser.LeftFlipperContext ctx) {
        // leftFlipper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER
        // ORIENTATIONFIELD INTEGER;
        String name = null;
        int x = 0;
        int y = 0;
        int orientation = 0;
        for (int i = 0; i < 4; i++) {
            String value = stack.pop();
            String field = stack.pop();
            if (field.equals("name=")) {
                name = value;
            }
            if (field.equals("x=")) {
                x = Integer.parseInt(value);
            }

            if (field.equals("y=")) {
                y = Integer.parseInt(value);
            }

            if (field.equals("orientation=")) {
                orientation = Integer.parseInt(value);
            }
        }
        LeftFlipper l;
        try {
            l = new LeftFlipper(x, y, orientation, name);
            flippers.add(l);
            allParts.add(l);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void enterGravity(BoardMakerParser.GravityContext ctx) {
    }

    @Override
    public void exitGravity(BoardMakerParser.GravityContext ctx) {
        // gravity: GRAVITYFIELD FLOAT;
        TerminalNode token = ctx.GRAVITYFIELD();
        String text = token.getText();
        String node = new String(text);
        stack.push(node);
        token = ctx.FLOAT();
        text = token.getText();
        node = new String(text);
        stack.push(node);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void visitTerminal(TerminalNode node) {
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
    }

    public ArrayList<Stationary> getStationary() {
        return nonMovingParts;
    }

    public ArrayList<Flipper> getFlippers() {
        return flippers;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public float getGravity() {
        return this.gravity;
    }

    public float getFriction1() {
        return this.friction1;
    }

    public float getFriction2() {
        return this.friction2;
    }

    public String getBoardName() {
        return this.boardName;
    }

    public ConcurrentHashMap<String, Gadget> getTriggerMap() {
        // getNameMap() that returns a HashMap<String, Gadget>
        ConcurrentHashMap<String, Gadget> newMap = new ConcurrentHashMap<String, Gadget>();
        for (String key : triggerMap.keySet()) {
            String value = triggerMap.get(key);
            for (Gadget g : allParts) {
                if (g.getName() == value) {
                    newMap.put(key, g);
                }
            }
        }

        return newMap;

    }

    public HashMap<String, Gadget> getNameMap() {
        HashMap<String, Gadget> newMap = new HashMap<String, Gadget>();
        for (Gadget g : allParts) {
            newMap.put(g.getName(), g);
        }

        return newMap;

    }

    public ArrayList<Gadget> getPartsList() {
        return this.allParts;
    }

}
