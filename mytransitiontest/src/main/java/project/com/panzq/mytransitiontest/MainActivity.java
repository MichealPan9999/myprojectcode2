package project.com.panzq.mytransitiontest;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {

    Scene mScene1, mScene2, mScene3;
    ViewGroup mSceneRoot;
    TransitionManager mTransitonManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSceneRoot = (ViewGroup) findViewById(R.id.sceneRoot);
        TransitionInflater inflater = TransitionInflater.from(this);
        // Note that this is not the only way to create a Scene object, but that
        // loading them from layout resources cooperates with the
        // TransitionManager that we are also loading from resources, and which
        // uses the same layout resource files to determine the scenes to transition
        // from/to.
        mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.transition_scene1, this);
        mScene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.transition_scene2, this);
        mScene3 = Scene.getSceneForLayout(mSceneRoot, R.layout.transition_scene3, this);
        mTransitonManager = inflater.inflateTransitionManager(R.transition.transitions_mgr,mSceneRoot);
    }
    public void selectScene(View view)
    {
        switch (view.getId())
        {
            case R.id.scene1:
                mTransitonManager.transitionTo(mScene1);
                break;
            case R.id.scene2:
                mTransitonManager.transitionTo(mScene2);
                break;
            case R.id.scene3:
                mTransitonManager.transitionTo(mScene3);
                break;
            case R.id.scene4:
                // scene4 is not an actual 'Scene', but rather a dynamic change in the UI,
                // transitioned to using beginDelayedTransition() to tell the TransitionManager
                // to get ready to run a transition at the next frame
                TransitionManager.beginDelayedTransition(mSceneRoot);
                setNewSize(R.id.view1,150,25);
                setNewSize(R.id.view2,150,25);
                setNewSize(R.id.view3,150,25);
                setNewSize(R.id.view4,150,25);
                break;

        }
    }
    private void setNewSize(int id, int width, int height) {
        View view = findViewById(id);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }
}
