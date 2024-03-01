import { useState, useEffect } from "react";
import axios from "axios";
import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

const ViewAllJobs = () => {
  const employer = JSON.parse(sessionStorage.getItem("active-employer"));
  const employer_jwtToken = sessionStorage.getItem("employer-jwtToken");

  const [allJobs, setAllJobs] = useState([
    {
      id: "",
      employer: {
        id: "",
        firstName: "",
        lastName: "",
        emailId: "",
        phoneNo: "",
        role: "",
        address: {
          id: "",
          street: "",
          city: "",
          pincode: "",
          state: "",
          country: "",
        },
        registrationDate: "",
        status: "",
      },
      title: "",
      description: "",
      category: {
        id: "",
        name: "",
        description: "",
        status: "",
      },
      companyName: "",
      companyLogo: "",
      address: {
        id: "",
        street: "",
        city: "",
        pincode: "",
        state: "",
        country: "",
      },
      jobType: "",
      salaryRange: "",
      experienceLevel: "",
      requiredSkills: "",
      status: "",
      datePosted: "",
      applicationCount: "",
    },
  ]);

  let navigate = useNavigate();

  useEffect(() => {
    const getAllJobs = async () => {
      const allJobs = await retrieveAllJobs();
      if (allJobs) {
        setAllJobs(allJobs.jobs);
      }
    };

    getAllJobs();
  }, []);

  const retrieveAllJobs = async () => {
    const response = await axios.get("http://localhost:8080/api/job/fetch/all");
    console.log(response.data);
    return response.data;
  };

  const formatDateFromEpoch = (epochTime) => {
    const date = new Date(Number(epochTime));
    const formattedDate = date.toLocaleString(); // Adjust the format as needed

    return formattedDate;
  };

  const viewAppliedJobs = (jobId) => {
    navigate(`/job/${jobId}/application/all`);
  };

  return (
    <div className="mt-3">
      <div
        className="card form-card ms-2 me-2 mb-5 shadow-lg"
        style={{
          height: "45rem",
        }}
      >
        <div
          className="card-header custom-bg-text text-center bg-color"
          style={{
            borderRadius: "1em",
            height: "50px",
          }}
        >
          <h2>All Jobs</h2>
        </div>
        <div
          className="card-body"
          style={{
            overflowY: "auto",
          }}
        >
          <div className="table-responsive">
            <table className="table table-hover text-color text-center">
              <thead className="table-bordered border-color bg-color custom-bg-text">
                <tr>
                  <th scope="col">Company Name</th>
                  <th scope="col">Company</th>
                  <th scope="col">Job</th>
                  <th scope="col">Description</th>
                  <th scope="col">Category</th>
                  <th scope="col">Type</th>
                  <th scope="col">Salary Range</th>
                  <th scope="col">Experience</th>
                  <th scope="col">Skills Required</th>
                  <th scope="col">Location</th>
                  <th scope="col">Posted Date</th>
                  <th scope="col">Application Count</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                {allJobs.map((job) => {
                  return (
                    <tr>
                      <td>
                        <b>{job.companyName}</b>
                      </td>
                      <td>
                        <img
                          src={
                            "http://localhost:8080/api/job/" + job.companyLogo
                          }
                          class="img-fluid"
                          alt="food_pic"
                          style={{
                            maxWidth: "90px",
                          }}
                        />
                      </td>
                      <td>
                        <Link
                          to={`/job/${job.id}/detail`}
                          style={{ textDecoration: "none" }}
                          className="text-color"
                        >
                          <b>{job.title}</b>
                        </Link>
                      </td>
                      <td>
                        <b>{job.description}</b>
                      </td>
                      <td>
                        <b>{job.category.name}</b>
                      </td>
                      <td>
                        <b>{job.jobType}</b>
                      </td>
                      <td>
                        <b>{job.salaryRange}</b>
                      </td>
                      <td>
                        <b>{job.experienceLevel}</b>
                      </td>
                      <td>
                        <b>{job.requiredSkills}</b>
                      </td>
                      <td>
                        <b>{job.address.city}</b>
                      </td>
                      <td>
                        <b>{formatDateFromEpoch(job.datePosted)}</b>
                      </td>
                      <td>
                        <b>{job.applicationCount}</b>
                      </td>
                      <td>
                        <button
                          onClick={() => viewAppliedJobs(job.id)}
                          className="btn btn-sm bg-color custom-bg-text ms-2"
                        >
                          Applications
                        </button>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ViewAllJobs;
