package com.abereth.event.view.transitions;

import com.abereth.event.view.ViewEvent;
import com.abereth.view.View;

/**
 * Created by sanic on 18/11/2014.
 */
public class FadeTransition extends ViewTransition
{
	private float speed;

	public FadeTransition( float speed )
	{
		super( false );
		this.speed = speed;
	}

	@Override
	public void init( View from, final View to  )
	{
		super.init( from );

		from.fadeOut( speed );
		from.getEventManager().add( new ViewEvent()
		{
			private boolean ran = false;

			@Override
			public boolean isDone( View view )
			{
				return ran;
			}

			@Override
			public void onUpdate(int delta, View view)
			{
				ran = true;
				view.getGame().detachView( view );
				view.getGame().addView( to );
				to.VIEW_COLOR.setA( 0f );
				to.fadeIn( speed );
			}
		}, true );

		this.isTransitionFinished = true;
	}

	@Override
	public void onUpdate(int delta, View view)
	{}

}
