package hunter2d.View;

import hunter2d.Super.Super;
import hunter2d.game.Handler;

public class WorldTextView extends View {
    private Handler world;
    
    public WorldTextView(Handler world) {
        this.world = world;
    }

    @Override
    public void render() {
        for (int i = 0; i < this.world.player.size(); i++) {
            Super p = this.world.player.get(i);
            
            System.out.println("Player is at " + p.x + "," + p.y);
		}
    }
}