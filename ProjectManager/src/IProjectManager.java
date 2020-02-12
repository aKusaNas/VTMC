import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import lt.itakademija.exam.Issue;
import lt.itakademija.exam.Project;
import lt.itakademija.exam.ProjectManager;

public class IProjectManager implements ProjectManager {

	private Collection<Issue> issueList = new ArrayList<Issue>();
	private Collection<Project> projectList = new ArrayList<Project>();

	@Override
	public Issue createIssue(Project project, String summary) {
		if (!summary.isEmpty()) {
		} else {
			throw new IllegalArgumentException();
		}
		if (project != null & !summary.equals(null)) {
		} else {
			throw new NullPointerException();
		}
		Issue newIssue = new Issue(project, summary);
		issueList.add(newIssue);

		return newIssue;

	}

	@Override
	public Issue createIssue(String projectId, String summary) {
		if (!projectId.isEmpty() & !summary.isEmpty()) {
		} else {
			throw new IllegalArgumentException();
		}
		if (!projectId.equals(null) & !summary.equals(null)) {
		} else {
			throw new NullPointerException();
		}

		Project q = new Project(projectId, summary);
		Issue newIssue = new Issue(q, summary);
		issueList.add(newIssue);

		return newIssue;
	}

	@Override
	public Project createProject(String id, String summary) {
		if (!id.isEmpty() & !summary.isEmpty()) {
		} else {
			throw new IllegalArgumentException();
		}
		if (!id.equals(null) & !summary.equals(null)) {
		} else {
			throw new NullPointerException();
		}
		Project newProject = new Project(id, summary);
		projectList.add(newProject);

		return newProject;
	}

	@Override
	public Collection<Issue> getIssues(Project project) {

		return issueList.stream().filter(iss -> iss.getProject().equals(project)).collect(Collectors.toList());
	}

	@Override
	public Collection<Issue> getIssues(String projectId) {

		return issueList.stream().filter(iss -> iss.getProject().getId().equals(projectId))
				.collect(Collectors.toList());
	}

	@Override
	public Project getProjectById(String id) {

		return projectList.stream().filter(project -> project.getId().equals(id)).findAny().get();
	}

	@Override
	public Collection<Project> getProjects() {

		return projectList;
	}

}
