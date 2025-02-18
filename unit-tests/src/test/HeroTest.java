package test;

import codingfactory.rpgconsole.enemy.Enemy;
import codingfactory.rpgconsole.hero.Hero;
import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HeroTest {

	Hero hero;
	Enemy enemy;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Avant le démarrage");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Après tous les tests");
	}

	@Before
	public void setUp() throws Exception {
		hero = new Hero("Jaina Portvaillant");
		enemy = new Enemy("Skeletton", 1);
		System.out.println("Avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Après un test");
	}

	@Test
	public void testHeroLevelUp() throws Exception {
		hero.levelUp();
		assertThat(hero, hasProperty("level", is(2)));
	}

	@Test
	public void testHeroAttack() throws Exception {
		hero.attack(enemy);
		assertThat(enemy, hasProperty("hp", lessThan(15)));
	}

	@Test
	public void testHeroTakeDmg() throws Exception {
		hero.takeDamage(5);
		assertThat(hero, hasProperty("hp", lessThan(20)));
	}

	@Test
	public void testHeroProperties() throws Exception {
		assertThat(hero, hasProperty("name"));
        assertThat(hero, hasProperty("name", is("Jaina Portvaillant")));
		assertThat(hero, hasProperty("level"));
		assertThat(hero, hasProperty("level", is(1)));
		assertThat(hero, hasProperty("hp"));
		assertThat(hero, hasProperty("hp", is(20)));
		assertThat(hero, hasProperty("atk"));
		assertThat(hero, hasProperty("atk", is(2)));
	}

}
