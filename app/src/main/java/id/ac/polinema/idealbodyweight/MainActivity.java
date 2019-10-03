package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.Fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.Fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.Fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.Fragments.ResultFragment;

public class MainActivity extends AppCompatActivity implements
		MenuFragment.OnFragmentInteractionListener,
		BrocaIndexFragment.OnFragmentInteractionListener,
		ResultFragment.OnFragmentInteractionListener {

	private AboutFragment af;
	private MenuFragment mf;
	private BrocaIndexFragment bif;
	private ResultFragment rf;
	// Deklarasikan atribut Fragment di sini

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		af = AboutFragment.newInstance("Ika Puspa Fairuz Wiwanata");
		mf = new MenuFragment();
		bif = new BrocaIndexFragment();
		rf = new ResultFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, mf)
				.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if(item.getItemId() == R.id.menu_about){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, af)
					.addToBackStack(null)
					.commit();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bif)
				.commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {

	}

	@Override
	public void onCalculateBrocaIndexClick(float index) {
		rf.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, rf)
				.commit();
	}

	@Override
	public void onTryAgainButtonClicked(String tag) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bif)
				.commit();
	}
}
